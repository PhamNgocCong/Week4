class ArrayUtils {
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public static <T extends Comparable<T>> void sort(T[] array){
        if (array == null || array.length<=1) {
            return;
        }

        int n = array.length;
        for(int i=0;i<n-1;i++){
            for (int j =0;j<n-1-i;j++){
                if(array[j].compareTo(array[j+1])>0){
                    swap(array, j, j+1);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args){
        Integer[] numbers={5,1,3,2};
        ArrayUtils.sort(numbers);
       for(int i:numbers) System.out.print(i+" ");
       System.out.println();
        String[] words = {"Java", "C++", "Python"};
        ArrayUtils.sort(words);
        for(String i:words) System.out.print(i+" ");
        System.out.println();

        Student[] students = {
                new Student("Nam", 8.5),
                new Student("An", 9.0),
                new Student("Binh", 7.5)
        };
        ArrayUtils.sort(students);
        for (Student s : students) {
            System.out.print(s+" ");
        }
    }
}
