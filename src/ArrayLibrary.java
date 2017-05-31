import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ArrayLibrary {

    public float Max(float[] array) {
        if (Size(array) == 0) {
            return Float.MAX_VALUE;
        }

        float maxValue = 0.0f;
        for (float item : array) {
            if (item > maxValue) {
                maxValue = item;
            }
        }

        return maxValue;
    }

    public float Min(float[] array) {
        if (Size(array) == 0) {
            return Float.MIN_VALUE;
        }

        float minValue = array[0];

        for (float item : array) {
            if (item < minValue) {
                minValue = item;
            }
        }

        return minValue;
    }

    public float Average(float[] array) {
        int size = Size(array);
        if (size == 0) {
            return Float.MIN_VALUE;
        }

        int sum = 0;
        for (float item : array) {
            sum += item;
        }

        return sum / size;
    }

    public float StandardDeviation(float[] array) {
        int size = Size(array);
        if (size == 0) {
            return Float.MIN_VALUE;
        }

        float average = Average(array);
        float temporary = 0f;
        for (float item : array) {
            temporary += (item - average) * (item - average);
        }

        return (float) Math.sqrt(temporary / size);
    }

    public int Size(Object[] arr) {
        if (arr == null) {
            return 0;
        }

        int size = 0;
        for (Object obj : arr) {
            size++;
        }

        return size;
    }

    public int Size(Object arr) {
        return Size(CastObjectToObjectArray(arr));
    }

    public <E extends Object> E[] Reverse(E[] originalArray) {
        int arraySize = Size(originalArray);
        if (arraySize == 0) {
            return null;
        }

        for (int i = 0; i < arraySize / 2; i++) {
            E temporary = originalArray[i];
            originalArray[i] = originalArray[(arraySize - 1) - i];
            originalArray[(arraySize - 1) - i] = temporary;
        }

        return originalArray;
    }

    public int[] Sort(int[] unsortedArray) {
        return Sort(unsortedArray, "asc");
    }

    public double[] Sort(double[] unsortedArray) {
        return Sort(unsortedArray, "asc");
    }

    public float[] Sort(float[] unsortedArray) {
        return Sort(unsortedArray, "asc");
    }

    public short[] Sort(short[] unsortedArray) {
        return Sort(unsortedArray, "asc");
    }

    public float[] Sort(float[] unsortedArray, String sortType) {
        int arraySize = Size(unsortedArray);
        if (arraySize == 0) {
            return null;
        }

        return CastObjectToPrimitive(Sort(CastPrimitiveToObject(unsortedArray, arraySize), sortType), arraySize);
    }

    private Float[] CastPrimitiveToObject(float[] ori, int size) {
        Float[] arr = new Float[size];
        for (int i = 0; i < size; i++)
            arr[i] = ori[i];
        return arr;
    }

    private float[] CastObjectToPrimitive(Float[] ori, int size) {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++)
            arr[i] = ori[i];
        return arr;
    }

    public int[] Sort(int[] unsortedArray, String sortType) {
        int arraySize = Size(unsortedArray);
        if (arraySize == 0) {
            return null;
        }

        Integer[] casted = CastPrimitiveToObject(unsortedArray, arraySize);
        Integer[] sorted = Sort(casted, sortType);
        return CastObjectToPrimitive(sorted, arraySize);
    }

    private Integer[] CastPrimitiveToObject(int[] ori, int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++)
            arr[i] = ori[i];
        return arr;
    }

    private int[] CastObjectToPrimitive(Integer[] ori, int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = ori[i];
        return arr;
    }

    public short[] Sort(short[] unsortedArray, String sortType) {
        int arraySize = Size(unsortedArray);
        if (arraySize == 0) {
            return null;
        }

        return CastObjectToPrimitive(Sort(CastPrimitiveToObject(unsortedArray, arraySize), sortType), arraySize);
    }

    private Short[] CastPrimitiveToObject(short[] ori, int size) {
        Short[] arr = new Short[size];
        for (int i = 0; i < size; i++)
            arr[i] = ori[i];
        return arr;
    }

    private short[] CastObjectToPrimitive(Short[] ori, int size) {
        short[] arr = new short[size];
        for (int i = 0; i < size; i++)
            arr[i] = ori[i];
        return arr;
    }

    public double[] Sort(double[] unsortedArray, String sortType) {
        int arraySize = Size(unsortedArray);
        if (arraySize == 0) {
            return null;
        }

        return CastObjectToPrimitive(Sort(CastPrimitiveToObject(unsortedArray, arraySize), sortType), arraySize);
    }

    private Double[] CastPrimitiveToObject(double[] ori, int size) {
        Double[] arr = new Double[size];
        for (int i = 0; i < size; i++)
            arr[i] = ori[i];
        return arr;
    }

    private double[] CastObjectToPrimitive(Double[] ori, int size) {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++)
            arr[i] = ori[i];
        return arr;
    }

    public <E extends Comparable<E>> E[] Sort(E[] unsortedArray) {
        return Sort(unsortedArray, "asc");
    }

    public <E extends Comparable<E>> E[] Sort(E[] unsortedArray, String sortType) {
        int arraySize = Size(unsortedArray);
        if (arraySize == 0) {
            return null;
        }

        if (sortType == "asc") {
            for (int j = 0; j < arraySize; j++) {
                for (int k = 0; k < arraySize; k++) {
                    if (unsortedArray[k].compareTo(unsortedArray[j]) > 0) {
                        E buffer = unsortedArray[j];
                        unsortedArray[j] = unsortedArray[k];
                        unsortedArray[k] = buffer;
                    }
                }
            }
        } else {
            for (int j = 0; j < arraySize; j++) {
                for (int k = 0; k < arraySize; k++) {
                    if (unsortedArray[k].compareTo(unsortedArray[j]) < 0) {
                        E buffer = unsortedArray[j];
                        unsortedArray[j] = unsortedArray[k];
                        unsortedArray[k] = buffer;
                    }
                }
            }
        }

        return unsortedArray;
    }

    private Object[] CastObjectToObjectArray(Object object) {
        if (object == null) {
            return null;
        }

        ArrayList objArr = new ArrayList();

        if (object instanceof int[]) {
            for (int i : (int[]) object) {
                objArr.add(i);
            }
        } else if (object instanceof char[]) {
            for (char c : (char[]) object) {
                objArr.add(c);
            }
        } else if (object instanceof byte[]) {
            for (byte b : (byte[]) object) {
                objArr.add(b);
            }
        } else if (object instanceof float[]) {
            for (float f : (float[]) object) {
                objArr.add(f);
            }
        } else if (object instanceof boolean[]) {
            for (boolean b : (boolean[]) object) {
                objArr.add(b);
            }
        } else if (object instanceof long[]) {
            for (long l : (long[]) object) {
                objArr.add(l);
            }
        } else if (object instanceof short[]) {
            for (short s : (short[]) object) {
                objArr.add(s);
            }
        } else if (object instanceof Object[]) {
            for (Object o : (Object[]) object) {
                objArr.add(o);
            }
        } else {
            objArr.add(object);
        }

        return objArr.toArray();
    }
}
