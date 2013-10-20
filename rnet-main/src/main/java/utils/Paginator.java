package utils;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/17/13
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class Paginator {
    private static int pageIndex;

    public Paginator() {
        pageIndex = 0;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int next() {
        pageIndex++;
        return getPageIndex();
    }
}
