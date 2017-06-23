package study.variables;

public class ArrayCopyDemo {
	public static void main(String[] args) {
        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
			    'i', 'n', 'a', 't', 'e', 'd' };
        char[] copyTo = new char[7];
        char[] copyTo2 = java.util.Arrays.copyOfRange(copyFrom, 2, 9);
        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));
        System.out.println(new String(copyTo2));
        
        // array manipulation
        
        java.util.Arrays.sort(copyTo);
        System.out.println(new String(copyTo));
        
        java.util.Arrays.parallelSort(copyTo2);
        System.out.println(new String(copyTo2));
        
        
        System.out.println(copyTo.equals(copyTo2));
        System.out.println(copyTo.equals(copyTo));
    }
}
