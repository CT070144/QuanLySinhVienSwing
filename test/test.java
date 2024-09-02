package test;



import java.awt.EventQueue;

import view.LoginView;

import view.QLSVView;

public class test {
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
			  // QLSVView ex2 = new QLSVView();
			   LoginView ex = new LoginView();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}}
