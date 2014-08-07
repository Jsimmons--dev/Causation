package com.noonsmsmannish;

import com.noonsmsmannish.view.View;

public class Main{

	private static View view;
	
	public static void main(String[] args){
		View view = View.makeView();
		Main.view = view;
	}

	public static View getView() {
		return view;
	}
	
	
	
}
