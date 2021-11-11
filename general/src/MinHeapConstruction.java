import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinHeapConstruction {

    public static void main(String[] args) {

        MinHeap minHeap =
                new MinHeap(
                        new ArrayList<>(
                                Arrays.asList(-7, 2, 3, 8, -10, 4, -6, -10, -2, -7, 10, 5, 2, 9, -9, -5, 3, 8)));

        List<Integer> res = minHeap.heap;
        minHeap.remove();
        System.out.println("IS mean heap " + isMinHeapPropertySatisfied(res));

        minHeap.insert(-8);
        res = minHeap.heap;
        System.out.println("IS mean heap " + isMinHeapPropertySatisfied(res));
        minHeap.remove();
        res = minHeap.heap;
        System.out.println();
        System.out.println("IS mean heap " + isMinHeapPropertySatisfied(res));
    }

    //       5
    //      / \
    //    10   21   parent = floor (i-1/2)   child1 = 2*i + 1   child2 = 2*i + 2
    //   /  \    \
    //  15  52    23
    // 5, 10, 21, 15, 52, 23

    public static boolean isMinHeapPropertySatisfied(List<Integer> array) {
        for (int currentIdx = 1; currentIdx < array.size(); currentIdx++) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                return true;
            }
            if (array.get(parentIdx) > array.get(currentIdx)) {
                return false;
            }
        }
        return true;
    }

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int nextParent = (array.size() - 2) / 2;
            while (nextParent >= 0 && nextParent < array.size()) {
                moveDown(nextParent, array);
                nextParent--;
            }
            return new ArrayList<>(array);
        }

        public int peek() {
            return heap.get(0);
        }

        public void moveDown(int currInd, List<Integer> heap) {
            while (currInd < heap.size()) {
                int childInd1 = 2 * currInd + 1;
                int childInd2 = 2 * currInd + 2;

                int newInd = -1, newVal = -1;
                if (childInd1 < heap.size() && childInd2 < heap.size()) {
                    if (heap.get(childInd1) <= heap.get(childInd2)) {
                        newInd = childInd1;
                    } else {
                        newInd = childInd2;
                    }
                } else if (childInd1 < heap.size() && childInd2 >= heap.size()) {
                    newInd = childInd1;
                } else if (childInd2 < heap.size() && childInd1 >= heap.size()) {
                    newInd = childInd2;
                } else {
                    break;
                }
                newVal = heap.get(newInd);
                if (newVal < heap.get(currInd)) {
                    heap.set(newInd, heap.get(currInd));
                    heap.set(currInd, newVal);
                    currInd = newInd;
                } else {
                    break;
                }
            }
        }

        // remove the root
        public int remove() {
            int val = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            moveDown(0, heap);
            return val;
        }

        public void insert(int value) {
            // start from the bottom
            int currInd = heap.size(); // 6
            heap.add(value);
            int parentInd = (int) Math.floor((currInd - 1) / 2); // 2
            int parent = heap.get(parentInd); //21
            while (parent > value) {
                int tmp = heap.get(parentInd);
                heap.set(parentInd, heap.get(currInd));
                heap.set(currInd, tmp);
                currInd = parentInd;
                //new parent ind
                parentInd = (int) Math.floor((currInd - 1) / 2);
                if (parentInd < 0) {
                    break;
                }
                parent = heap.get(parentInd);
            }
        }
    }
}
