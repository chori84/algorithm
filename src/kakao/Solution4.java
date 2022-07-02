package kakao;

public class Solution4 {
    public static void main(String[] args) {
        System.out.println(programmerStrings("xramprogmerxxppprograemmeereexx"));
    }
    static int[] literalCount = {1, 3, 1, 1, 1, 2};
    static int p = 0;
    static int r = 1;
    static int o = 2;
    static int g = 3;
    static int a = 4;
    static int m = 5;

    static int programmerStrings(String str) {
        char[] sArray = str.toCharArray();

        int first;
        for (first = 0; first < sArray.length; first++) {
            find(sArray, first);

            if(check()) {
                break;
            }
        }

        literalCount = new int[]{1, 3, 1, 1, 1, 2};

        int second;
        for (second = sArray.length - 1; second >= 0; second--) {
            find(sArray, second);

            if(check()) {
                break;
            }
        }

        System.out.println(first);
        System.out.println(second);

        if (second <= first) {
            return 0;
        } else {
            return second - 1 - first;
        }
    }

    private static void find(char[] sArray, int second) {
        if(sArray[second] == 'p') {
            literalCount[p]--;
        } else if(sArray[second] == 'r') {
            literalCount[r]--;
        } else if(sArray[second] == 'o') {
            literalCount[o]--;
        } else if(sArray[second] == 'g') {
            literalCount[g]--;
        } else if(sArray[second] == 'a') {
            literalCount[a]--;
        } else if(sArray[second] == 'm') {
            literalCount[m]--;
        }
    }

    static boolean check() {
        if(literalCount[p] <= 0 &&
            literalCount[r] <= 0 &&
            literalCount[o] <= 0 &&
            literalCount[g] <= 0 &&
            literalCount[a] <= 0 &&
            literalCount[m] <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
