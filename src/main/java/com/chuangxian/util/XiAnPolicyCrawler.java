package com.chuangxian.util;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;
import com.chuangxian.entity.Policy;
import com.chuangxian.service.PolicyService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class XiAnPolicyCrawler extends BreadthCrawler {
    private List<Policy> policies = new ArrayList<>();

    @Resource
    private PolicyService policyService;

    /**
     * Crawling news from github news
     * 自动 弹出 URL 地址，继承 BreadthCrawler（广度爬虫）
     * cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler是基于RocksDB的插件,于2.72版重新设计
     * BreadthCrawler可以设置正则规律，让遍历器自动根据URL的正则遍历网站，可以关闭这个功能，自定义遍历
     * 如果autoParse设置为true，遍历器会自动解析页面中符合正则的链接，加入后续爬取任务，否则不自动解析链接。
     * 注意，爬虫会保证爬取任务的唯一性，也就是会自动根据CrawlDatum的key进行去重，默认情况下key就是URL，
     * 所以用户在编写爬虫时完全不必考虑生成重复URL的问题。
     * 断点爬取中，爬虫仍然会保证爬取任务的唯一性。
     *
     * @param page 用于此网站特殊爬取
     */

    public XiAnPolicyCrawler(String crawlPath, boolean autoParse, int page, int catId) {
        /**
         * 构造一个基于 RocksDB 的爬虫
         * RocksDB文件夹为crawlPath，crawlPath中维护了历史URL等信息
         * 不同任务不要使用相同的crawlPath
         * 两个使用相同crawlPath的爬虫并行爬取会产生错误
         *
         * @param crawlPath RocksDB使用的文件夹
         * @param autoParse 是否根据设置的正则自动探测新URL ,默认为 true
         */
        super(crawlPath, autoParse);

        /**
         * 只有在autoParse和autoDetectImg都为true的情况下
         * 爬虫才会自动解析图片链接
         */
        getConf().setAutoDetectImg(true);

        /**设置爬取的网站地址
         * addSeed 表示添加种子
         * 种子链接会在爬虫启动之前加入到抓取信息中并标记为未抓取状态.这个过程称为注入
         * 放入爬取的目标网址
         */
        //this.addSeed("http://xakj.xa.gov.cn/newpage/zcfgc.asp?id=396");
        this.addSeed("http://xakj.xa.gov.cn/newpage/zcfg.asp?page=" + page + "&catid=" + catId);

        /**
         * 添加一个 URL 正则规则 正则规则有两种，正正则和反正则
         * URL 符合正则规则需要满足两个条件： 1.至少能匹配一条正正则 2.不能和任何反正则匹配
         * 正正则示例：+abc.*efg 是一条正正则，正则的内容为 abc.*efg ，起始加号表示正正则
         * 反正则示例：-abc.*efg 是一条反正则，正则的内容为 abc.*efg ，起始减号表示反正则
         * (注1)如果一个规则的起始字符不为加号且不为减号，则该正则为正正则，正则的内容为自身，如 a.*c 是一条正正则，正则的内容为 a.*c
         * (注2) 正则的内容与平时 js 与 java 中使用的正则写法是一样的，如 "."表示任意字符、"*"表示0次或多次、[0-9]{4} 表示连续4个数字
         */
        this.addRegex("http://xakj.xa.gov.cn/newpage/zcfgc.asp.*");

        /**
         * 过滤 gif 图片地址
         * 垃圾网站一些gif图片过滤在下面，此处过滤是和文章url类似的图片网页
         * 例：http://xakj.xa.gov.cn/newpage/zcfgc.asp/12.jpg
         */
        //this.addRegex("-.*/icon16/.*.gif");
        //this.addRegex("-.*.gif");

        /**设置线程数*/
        setThreads(20);

        /**爬去网址个数最大值*/
        getConf().setTopN(100);

        /**
         * 是否进行断点爬取，默认为 false
         * setResumable(true);
         */
    }


    /**
     * 必须重写 visit 方法，作用是:
     * 在整个抓取过程中,只要抓到符合要求的页面,webCollector 就会回调该方法,并传入一个包含了页面所有信息的 page 对象
     *
     * @param page ：Page是爬取过程中，内存中保存网页爬取信息的一个容器，Page只在内存中存放，用于保存一些网页信息，方便用户进行自定义网页解析之类的操作。
     * @param next ：可以手工将希望后续采集的任务加到next中（会参与自动去重），即如果需要后续再次进行爬取的，则可以添加进去
     */
    @Override
    public void visit(Page page, CrawlDatums next) {
        String url = page.url();
        log.info(" page 类型：：" + page.contentType() + "   开始爬取 URL：：" + url);

        /**
         * 判断当前 Page 的 URL 是否和输入正则匹配
         * 如果此页面地址 确实是要求爬取网址，则进行取值，contentType 是页面请求的内容类型，可以通过浏览器 F12 查看
         */
        if (page.contentType().startsWith("text/html")) {
            /**
             * page 为 html 网页类型
             */
            if (page.matchUrl("http://xakj.xa.gov.cn/newpage/zcfgc.asp.*")) {
                Policy policy = new Policy();

                //标题
                String policyTitle = page.select("body > table:nth-child(6) > tbody > tr > td:nth-child(3) > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > strong").first().text();
                policy.setPoicyTitle(policyTitle);

                //级别
                String level = page.select("body > table:nth-child(6) > tbody > tr > td:nth-child(3) > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td:nth-child(2)").first().text().replace("级别：", "");
                policy.setLevel(level);

                //发文单位
                String publishInstitution = page.select("body > table:nth-child(6) > tbody > tr > td:nth-child(3) > table > tbody > tr > td > table > tbody > tr:nth-child(6) > td:nth-child(2)").first().text().replace("发文单位：", "");
                policy.setPublishInstitution(publishInstitution);

                //发文号
                String issuedNum = page.select("body > table:nth-child(6) > tbody > tr > td:nth-child(3) > table > tbody > tr > td > table > tbody > tr:nth-child(10) > td:nth-child(2)").first().text().replace("发文号：", "");
                policy.setIssuedNum(issuedNum);

                //类别
                String classify = page.select("body > table:nth-child(6) > tbody > tr > td:nth-child(3) > table > tbody > tr > td > table > tbody > tr:nth-child(8) > td:nth-child(2)").first().text().replace("类别：", "");
                policy.setClassify(classify);

                //内容
                String content = page.select("body > table:nth-child(6) > tbody > tr > td:nth-child(3) > table > tbody > tr > td > table > tbody > tr:nth-child(18) > td").first().text();
                policy.setPolicyContent(content);

                //发布时间
                String publishTime = page.select("body > table:nth-child(6) > tbody > tr > td:nth-child(3) > table > tbody > tr > td > table > tbody > tr:nth-child(14) > td:nth-child(2)").first().text().replace("发布日期：", "");
                policy.setPublishTime(String2DateUtils.parseDateStr(publishTime));

                //原文链接
                String originalUrl = page.url();
                policy.setOriginalUrl(originalUrl);

                Elements imgElements = page.select("body > table:nth-child(6) > tbody > tr > td:nth-child(3) > table > tbody > tr > td > table > tbody > tr:nth-child(18) > td > p > img");
                if (imgElements != null && !imgElements.toString().equals("")) {
                    for (Element imgElement : imgElements) {
                        String imageUrl = imgElement.attr("src");
                        if (!imageUrl.equals("/admin/xaeditor/sysimage/icon16/doc.gif") && !imageUrl.equals("/admin/xaeditor/sysimage/icon16/pdf.gif") && !imageUrl.equals("/admin/xaeditor/sysimage/icon16/zip.gif")) {
                            imageUrl = "http://xakj.xa.gov.cn" + imageUrl;
                            policy.setImageUrl(imageUrl);
                        }
                    }

                }
                Elements elements = page.select("body > table:nth-child(6) > tbody > tr > td:nth-child(3) > table > tbody > tr > td > table > tbody > tr:nth-child(18) > td > p > a");
                if (elements != null && !elements.toString().equals("")) {
                    for (Element element : elements) {
                        String fileUrl = "http://xakj.xa.gov.cn" + element.attr("href");
                        policy.setFileUrl(fileUrl);
                    }
                }
                policies.add(policy);
            }
        }
    }

    public List<Policy> result() {
        return policies;
    }



    /**
     * XiAnPolicyCrawler 构造器中会进行 数据初始化，这两个参数接着会传给父类
     * super(crawlPath, autoParse);
     * crawlPath：表示设置保存爬取记录的文件夹，本例运行之后会在应用根目录下生成一个 "crawl" 目录存放爬取信息
     * autoParse：表示进行 URL自动探测
     * 启动爬虫，爬取的深度为3层
     * 添加的第一层种子链接,为第1层，本例层级如下：
     * 第一层：爬取的目标网址，即文章列表页
     * 第二层：具体的文章内容页（此时需要获取的图片恰好就在其中）
     * 第三层：就是为了获取第二层中的图片地址
     * 垃圾网站，我已经在第二层将图片地址解析
     *
     * 以下是测试
     */
   /* public static void main(String[] args) throws Exception {
        //ContentExtractor contentExtractor;
        XiAnPolicyCrawler crawler = new XiAnPolicyCrawler("src/main/resources/crawl/", true, 1, 0);
        crawler.start(3);
    }*/
}

