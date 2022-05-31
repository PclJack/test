import java.io.*;
import java.util.HashSet;
import java.util.Set;

class UnionFind {
    int[] parent;
    public UnionFind(int siz) {
        parent = new int[siz];
        for (int i=0; i<siz; i++) {
            parent[i] = i;
        }
    }
    public void union(int i, int j) {
        int p1 = find(i);
        int p2 = find(j);
        parent[p1] = p2;
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }
    public int numberOfComponent() {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<parent.length; i++) {
            set.add(find(parent[i]));
        }
        return set.size();
    }
}

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = bf.readLine();
        String[] numbers = line.split(" ");
        int v = Integer.parseInt(numbers[0]);
        int e = Integer.parseInt(numbers[1]);
        UnionFind unionFind = new UnionFind(v);
        for (int i=0; i<e; i++) {
            line = bf.readLine();
            numbers = line.split(" ");
            int a = Integer.parseInt(numbers[0])-1;
            int b = Integer.parseInt(numbers[1])-1;
            unionFind.union(a, b);
        }
        bufferedWriter.write(Integer.toString(unionFind.numberOfComponent())+"\n");
        bufferedWriter.flush();
    }
}