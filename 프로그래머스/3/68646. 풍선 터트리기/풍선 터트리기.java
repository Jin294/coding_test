import java.util.*;

class Solution {
	public int solution(int[] a) {
		int answer = 0;
		int len = a.length;
		
		// 왼쪽부터 최솟값을 경신하며 저장
		int[] leftMin = new int[len];
		leftMin[0] = a[0];
		for (int i = 1; i < len; i++) {
			leftMin[i] = Math.min(leftMin[i - 1], a[i]);
		}
		
		// 오른쪽부터 최솟값을 경신하며 저장
		int[] rightMin = new int[len];
		rightMin[len - 1] = a[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			rightMin[i] = Math.min(rightMin[i + 1], a[i]);
		}
		
		// 타겟이 양쪽의 최솟값보다 큰 값인지 체크
		for (int i = 1; i <= len - 2; i++) {
			if (a[i] > leftMin[i] && a[i] > rightMin[i]) {
				answer++;
			}
		}
		return len - answer;
	}
}