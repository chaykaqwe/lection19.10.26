void quicksort(int[] array){
    if (array != null && array.length >= 2){
        quicksort(array, 0, array.length-1);
    }
}
void quicksort(int[] array, int low, int high){
    if (low >= high) {
        return;
    }
    int pivotIndex = partition(array, low, high);
    quicksort(array, low, pivotIndex - 1);
    quicksort(array, pivotIndex+1, high);
    }


int partition(int[] array, int low, int high){
    int pivot = array[high];
    int boundary = low;
    for (int i = low;i < high; i++){
        if (array[i] < pivot){
            swap(array, boundary, i);
            boundary++;
        }
    }
    swap(array, boundary, high);
    return boundary;
}

void swap(int[] array, int i, int j){
    var t = array[i];
    array[i] = array[j];
    array[j] = t;
}

void main() {
    // Алгоритм     |Ср. Время    |Худшее время| Доп память|
    // Пузырек      |O(n^2)       | O(n^2)     | O(1)      |
    // Выбором      |O(n^2)       | O(n^2)     | O(1)      |<- Для почти отсортитрованных
    // Быстрая      |O(n log n)   | O(n^2)     | O(log n)  |
    // Слияние      |O(n log n)   | O(n log n) | O(n)      |
    // Пирамидальная|O(n log n)   |O(n log n)  |O(1)       |
    // Timsort      |O(n log n)   |O(n log n)  |O(n)       |


    //Быстрая сортировка алг.
    //1. Выбор опорного элемента(pivot)
    //2. Перестановка элементов
    // [<=pivot -> pivot ->  >pivot]
    //3. Рекурсивная сортировка левой и правой части

    //[7, 2, 9, 4, 3, 8, 5]
    //                   ^ опорный элемент
    // low               high
    //pivot = 5
    //boundary = low
    // 7 >= 5-пропуск
    // 2 <= 5 - обмен
    //[2, 7, 9, 4, 3, 8, 5]
    //9>5 - скип
    // 4 <= 5 - обмен с boundary
    //[2, 4, 9, 7, 3, 8, 5] boudary++(2)
    //3 <= 5
    //[2, 4, 3, 7, 9, 8, 5] boudary++(3)
    //8>5
    //[2, 3, 4, 5, 9, 8, 7]
    int[] numbers = {7, 2, 9, 4, 3, 8, 5};
    quicksort(numbers);
    System.out.println(Arrays.toString(numbers));
}