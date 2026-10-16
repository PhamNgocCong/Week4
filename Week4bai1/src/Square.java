public class Square extends Shape{
    public Square(int x,int y)
    {
        super(x,y);
    }
    public void draw() {
        System.out.println("Vẽ hình vuông tại x=" + x + " và y=" + y);
    }
    public void erase() {
        System.out.println("Xoá hình vuông tại x=" + x + " và y=" + y);
    }
}
