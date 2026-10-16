public class Circle extends Shape{
    public Circle(int x,int y)
    {
        super(x,y);
    }
public void draw() {
    System.out.println("Vẽ hình tròn tại x=" + x + " và y=" + y);
}
public void erase() {
    System.out.println("Xoá hình tròn tại x=" + x + " và y=" + y);
}
}
