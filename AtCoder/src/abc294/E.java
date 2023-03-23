package abc294;

import java.util.Scanner;

public class E {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long l = sc.nextLong();
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		//各セグメントの区間と、開始・終了のインデックスを保存する。
		Segment[] seg1 = new Segment[n1];
		Segment[] seg2 = new Segment[n2];
		
		for(int i = 0;  i < n1; i++) {
			int value = sc.nextInt();
			long len = sc.nextLong();
			
			if(i == 0) {
				seg1[i] = new Segment(value, 0, len);
			}
			else {
				seg1[i] = new Segment(value, seg1[i - 1].end, seg1[i - 1].end + len);
			}
		}
		
		for(int i = 0;  i < n2; i++) {
			int value = sc.nextInt();
			long len = sc.nextLong();
			
			if(i == 0) {
				seg2[i] = new Segment(value, 0, len);
			}
			else {
				seg2[i] = new Segment(value, seg2[i - 1].end, seg2[i - 1].end + len);
			}
		}
		
		long result = 0;
		int index = 0;
		//seg2[i]と数字がかぶるseg1のセグメントを探す。
		//後戻りをする必要がないので尺取り方でO(N1+N2)でいける。
		for(int i = 0; i < n2; i++) {
			while(index < n1 && seg1[index].begin < seg2[i].end) {
				if(seg1[index].value == seg2[i].value) {
					result += Math.min(seg1[index].end, seg2[i].end) - seg1[index].begin;
				}
				//seg1[index]が完全にseg2[i]におさまっている場合
				if(seg1[index].end <= seg2[i].end) {
					index++;
				}
				//seg1[index]の右側がはみ出ている場合は再利用する可能性があるためindexを進めない。
				else {
					seg1[index].begin = seg2[i].end;
				}
			}
		}
		
		System.out.println(result);
		
	}		
}

class Segment {
	int value;
	long begin;
	long end;
	
	Segment(int value, long begin, long end){
		this.value = value;
		this.begin = begin;
		this.end = end;
	}
}