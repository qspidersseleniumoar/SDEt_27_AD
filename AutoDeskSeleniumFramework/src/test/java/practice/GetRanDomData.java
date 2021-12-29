package practice;

import java.util.Random;

public class GetRanDomData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random ran = new Random();
		int ranDomNum = ran.nextInt(10);
      System.out.println(ranDomNum);
	}

}
