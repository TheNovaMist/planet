import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Draw extends JPanel{
	/*
	 * Draw继承JPanel的所有方法
	 * 使用Graphics2D类来绘图
	 */
	
	//系统自动调用 JPanel的paintComponent方法
	public void paintComponent(Graphics g) {
		//长和宽
		int width = 600;
		int height = 600;
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
		
		Graphics2D g2d = (Graphics2D) g;
		//背景为宇宙黑
		g2d.setPaint(Color.black);
		g2d.fillRect(0, 0, width, height);
	
		g2d.setPaint(Color.white);
		g2d.setFont(new Font("Monospaced", Font.BOLD, 30));
		g2d.drawString("A Planet In The Universe", 25, 100);
		
		g2d.setFont(new Font("Monospaced", Font.BOLD, 25));
		g2d.setPaint(Color.white);
		g2d.drawString(sdf.format(new Date()), 10, 410);
		
		//随时生成大小不等的小白星
		int n = (int)(150 + 100*Math.random());
		for(int i=0;i<n;i++) {
			g2d.fillOval((int)(500*Math.random()), (int)(500*Math.random()), (int)(5*Math.random()), (int)(5*Math.random()));
		}
		
		//随机颜色
		int red = (int)(Math.random()*255);
		int green = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);
		Color startColor = new Color(red, green, blue);
		
		red = (int)(Math.random()*255);
		green = (int)(Math.random()*255);
		blue = (int)(Math.random()*255);
		Color endColor = new Color(red, green, blue);
		
		red = (int)(Math.random()*255);
		green = (int)(Math.random()*255);
		blue = (int)(Math.random()*255);
		Color loopColor = new Color(red, green, blue);
		
		//翻转画布
		g2d.rotate(-1*Math.PI / 10, 250, 250);
		
		//光环的上半环
		g2d.setStroke(new BasicStroke(5));	
		g2d.setPaint(loopColor);
		g2d.drawArc(50, 200, 400, 100, 0, 180);		
		
		//起点 开始颜色 终点 渐层最后的颜色
		GradientPaint gradient = new GradientPaint(150, 150, startColor, 350, 350, endColor);
		//笔刷换为渐层画星球
		g2d.setPaint(gradient);
		g2d.fillOval(150, 150, 200, 200);
		
		//R=100
		//光环的下半环
		g2d.setStroke(new BasicStroke(5));		
		g2d.setPaint(loopColor);
		g2d.drawArc(50, 200, 400, 100, 180, 180);
	}//关闭paint方法
}
