import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 目标：实现一个图形化的界面并在其画板上画出可改变颜色的小星球
 * 具体步骤：
 * - GUI基本设置
 * - 在继承JPanel的Draw类中画图
 * - 使用Timer令图画不断切换
 * - 按钮绑定鼠标事件监听通过点击控制画图切换的开始与停止
 */
public class Planet implements ActionListener, MouseListener {
	
	int a,b;
	int c = 0;
	boolean isFirstMeet = true;
	Timer timer;
	JFrame frame;
	JButton button;
	Draw d = new Draw();
	
	public static void main(String[] args) {
		Planet gui = new Planet();
		gui.go();
	}
	
	public void go() {
		//播放速度设定为1s
		timer = new Timer(1000,this);
		timer.start();
		
		frame = new JFrame("I'm changing! :>");
		
		button = new JButton("STOP");
		//注册监听器
		button.addMouseListener(this);
		
		//向frame上添加组件
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, d);
		
		//设定窗口固定大小、可见、关闭方式
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//关闭go
	
		//timer的相应
		//重画JPanel
		public void actionPerformed(ActionEvent e){
			a = (int)(10000*Math.random());
			b = (int)(10000*Math.random());
			frame.setTitle("第"+a+"号星系"+" 第"+b+"号小行星");
			frame.repaint();
			
			if(isFirstMeet) {
			c++;
			}
			if(c==30) {
				c++;
				isFirstMeet = false;
				frame.setTitle("刘培强你不要过来啊啊啊啊！！！！");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
			}
	
		}
		//鼠标按下控制timer的开始与停止
		public void mousePressed(MouseEvent e) {
			if(button.getText() == "STOP") {
				button.setText("START");
				String add = frame.getTitle();
				frame.setTitle(add+"  时间凝固在了这一刻👨‍🚀");
				//Let me changing! ( ´◔‸◔`) 
			}
			else {
				button.setText("STOP");
				}
			
			if (timer.isRunning()) {
				timer.stop();
			}else {
				timer.start();
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

}
