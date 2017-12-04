package com.example.shbae.tddexample;

import fitnesse.responders.run.SuiteResponder;
import fitnesse.wiki.*;

public class FitnessExample {
    public String testableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception {
        return new TestableHtmlMaker(pageData, includeSuiteSetup).invoke();
    }

    private class TestableHtmlMaker {
        private PageData pageData;
        private boolean includeSuiteSetup;
        private WikiPage wikiPage;
        private StringBuffer buffer;

        public TestableHtmlMaker(PageData pageData, boolean includeSuiteSetup) {
            this.pageData = pageData;
            this.includeSuiteSetup = includeSuiteSetup;
            wikiPage = pageData.getWikiPage();
            buffer = new StringBuffer();
        }

        public String invoke() throws Exception {

            if (isTastPage()) {
                includeSetups();
                buffer.append(pageData.getContent());
                includeTeardonws();
            }

            pageData.setContent(buffer.toString());
            return pageData.getHtml();
        }

        private boolean isTastPage() throws Exception {
            return pageData.hasAttribute("Test");
        }

        private void includeTeardonws() throws Exception {
            includeInherited("!include -teardown .", "TearDown");
            if (includeSuiteSetup) {
                String pageName = SuiteResponder.SUITE_TEARDOWN_NAME;
                includeInherited("!include -teardown .", pageName);
            }
        }

        private void includeSetups() throws Exception {
            if (includeSuiteSetup)
                includeInherited("!include -setup .", SuiteResponder.SUITE_SETUP_NAME);
            includeInherited("!include -setup .", "SetUp");
        }

        private void includeInherited(String nameStr, String pageName) throws Exception {
            WikiPage setup = PageCrawlerImpl.getInheritedPage(pageName, wikiPage);
            if (setup != null)
                includePage(nameStr, setup);
        }

        private void includePage(String nameStr, WikiPage teardown) throws Exception {
            WikiPagePath tearDownPath = wikiPage.getPageCrawler().getFullPath(teardown);
            String tearDownPathName = PathParser.render(tearDownPath);
            buffer.append(nameStr).append(tearDownPathName).append("\n");
        }
    }
}
