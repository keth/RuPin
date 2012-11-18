package is.ru.honn.rupin.domain;

public class Pin extends PinObject
{
  protected String link;
  protected String description;
  protected String image;
  protected Board board;
  protected String boardname;

  public Pin()
  {
  }

  public Pin(String link, String description, String image)
  {
    this.link = link;
    this.description = description;
    this.image = image;
  }

    public Pin(String description, String link, String image, String boardname) {
        //super(creator);
        //super.toString(getCreator()) = creator;
        this.description = description;
        this.link = link;
        this.image = image;
        this.boardname = boardname;
    }

    public Pin(User creator) {
        super(creator);
    }

    public String getLink()
  {
    return link;
  }

  public void setLink(String link)
  {
    this.link = link;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getImage()
  {
    return image;
  }

  public void setImage(String image)
  {
    this.image = image;
  }

  public Board getBoard()
  {
    return board;
  }

  public void setBoard(Board board)
  {
    this.board = board;
  }

    public String getBoardname() {
        return boardname;
    }

    public void setBoardname(String boardname) {
        this.boardname = boardname;
    }
}
