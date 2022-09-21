package Logic.Entitet;

public class Bog
{
    private String title;
    private String forfatter;
    private int bogId;

    public Bog(String title, String forfatter, int bogId)
    {
        this.title = title;
        this.forfatter = forfatter;
        this.bogId = bogId;
    }

    public Bog(String title, String forfatter)
    {
        this.title = title;
        this.forfatter = forfatter;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getForfatter()
    {
        return forfatter;
    }

    public void setForfatter(String forfatter)
    {
        this.forfatter = forfatter;
    }

    public int getBogId()
    {
        return bogId;
    }

    public void setBogId(int bogId)
    {
        this.bogId = bogId;
    }

    @Override
    public String toString()
    {
        return "Bog{" + "title='" + title + '\'' + ", forfatter='" + forfatter + '\'' + ", bogId=" + bogId + '}';
    }
}
