class Solution {
    public int[] solution(int[][] arr) {
        return divide(arr, 0, 0, arr.length);
    }

    // 영역 분할
    public int[] divide(int[][] arr, int x, int y, int size) {
        if (size == 1) {
            // 0이면 {1, 0}, 1이면 {0, 1} 반환
            return new int[]{1 - arr[y][x], arr[y][x]};
        }

        int[] count = new int[2];

        int value = check(arr, x, y, size);
        if (value != -1) {
            count[value]++;
        } else {
            int newSize = size / 2;
            count = combine(count, divide(arr, x, y, newSize));
            count = combine(count, divide(arr, x + newSize, y, newSize));
            count = combine(count, divide(arr, x, y + newSize, newSize));
            count = combine(count, divide(arr, x + newSize, y + newSize, newSize));
        }

        return count;
    }

    // 배열 합치기
    public int[] combine(int[] a, int[] b) {
        int[] rtn = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            rtn[i] = a[i] + b[i];
        }
        return rtn;
    }

    // 영역 안의 숫자가 모두 같은지 확인
    public int check(int[][] arr, int x, int y, int size) {
        int value = arr[y][x];
        for (int j = y; j < y + size; j++) {
            for (int i = x; i < x + size; i++) {
                if (arr[j][i] != value) {
                    return -1;
                }
            }
        }
        return value;
    }
}