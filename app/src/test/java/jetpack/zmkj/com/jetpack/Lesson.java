package jetpack.zmkj.com.jetpack;

/**
 * @author lijianjun
 * @description:
 * @date :2020/11/26 6:00 PM
 */
public class Lesson {
    private int lesson;
    private int start;
    private int count;

    public Lesson(int lesson, int start, int count) {
        this.lesson = lesson;
        this.start = start;
        this.count = count;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
