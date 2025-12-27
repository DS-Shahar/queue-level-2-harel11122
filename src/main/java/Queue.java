public class QueueAlgorithms {

    public static Queue<Integer> sequenceLengths(Queue<Character> q) {
        Queue<Integer> result = new Queue<>();
        if (q.isEmpty()) return result;

        char prev = q.remove();
        int count = 1;

        while (!q.isEmpty()) {
            char curr = q.remove();
            if (curr == prev) {
                count++;
            } else {
                result.insert(count);
                count = 1;
                prev = curr;
            }
        }
        result.insert(count);
        return result;
    }
    // Time: O(n) , Space: O(n)

    public static boolean hasDuplicates(Queue<String> q) {
        Queue<String> aux = new Queue<>();

        while (!q.isEmpty()) {
            String s = q.remove();
            if (isIn(s, aux)) return true;
            aux.insert(s);
        }
        return false;
    }
    // Time: O(n^2) , Space: O(n)

    public static void removeDuplicates(Queue<Integer> q) {
        Queue<Integer> aux = new Queue<>();

        while (!q.isEmpty()) {
            int x = q.remove();
            if (!isIn(x, aux)) {
                aux.insert(x);
            }
        }

        while (!aux.isEmpty()) {
            q.insert(aux.remove());
        }
    }
    // Time: O(n^2) , Space: O(n)

    public static void sortQueue(Queue<Integer> q) {
        Queue<Integer> sorted = new Queue<>();
        Queue<Integer> aux = new Queue<>();

        while (!q.isEmpty()) {
            int min = q.remove();
            aux.insert(min);

            while (!q.isEmpty()) {
                int x = q.remove();
                if (x < min) {
                    aux.insert(min);
                    min = x;
                } else {
                    aux.insert(x);
                }
            }

            sorted.insert(min);

            while (!aux.isEmpty()) {
                q.insert(aux.remove());
            }
        }

        while (!sorted.isEmpty()) {
            q.insert(sorted.remove());
        }
    }
    // Time: O(n^2) , Space: O(n)
}
