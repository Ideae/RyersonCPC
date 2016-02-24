

import java.util.*;

/**
 * Created by ZackLapt on 2016-02-03.
 */
public class Units2 {
    public static class Unit implements Comparable<Unit> {
        public String name;
        public long value;
        public boolean inverse;
        public Unit(String name, long value, boolean inverse) {
            this.name = name;
            this.value = value;
            this.inverse = inverse;
        }
        public int compareTo(Unit u1) {
            return (int)value - (int)u1.value;
        }
    }
    public static class Tuple{
        public int a, b;
        public Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static HashMap<String, HashMap<String, Unit>> map;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = Integer.parseInt(sc.next());
            if (n == 0) break;
            map = new HashMap<>();

            for(int i = 0; i < n; i++) {
                map.put(sc.next(), new HashMap<String, Unit>());
            }
            for(int i = 0; i < n-1; i++) {
                String name = sc.next();
                sc.next();
                int val = Integer.parseInt(sc.next());
                String name2 = sc.next();
                if (!map.containsKey(name)) {
                    map.put(name, new HashMap<String, Unit>());
                }
                map.get(name).put(name2, new Unit(name2, val, false));
                if (!map.containsKey(name2)) {
                    map.put(name2, new HashMap<String, Unit>());
                }
                map.get(name2).put(name, new Unit(name, val, true));
            }

            //track top unit as we iterate
            for(String name : map.keySet()) {
                for(String name2 : map.keySet()) {
                    if (name.equals(name2)) continue;
                    if (!map.get(name).containsKey(name2)) {
                        //find edge
                        HashSet<String> visited = new HashSet<>();
                        visited.add(name);
                        Tuple t = findRelation(visited, new Tuple(1,1), name, name2);
                        if (t == null) continue;
                        Unit u1 = new Unit(name2, 0, false);
                        if (t.a > t.b) {
                            u1.value = t.a / t.b;
                            u1.inverse = false;
                            long nval = u1.value;
                        }
                        else {
                            u1.value = t.b / t.a;
                            u1.inverse = true;
                        }
                        map.get(name).put(name2, u1);
                        map.get(name2).put(name, new Unit(name, u1.value, !u1.inverse));
                    }
                }
            }
            String topName = "";
            long topValue = 0;
            for(String name : map.keySet()) {
                for (String name2 : map.get(name).keySet()) {
                    Unit u = map.get(name).get(name2);
                    if (u.inverse) continue;
                    long nval = map.get(name).get(name2).value;
                    if (nval > topValue){
                        topValue = nval;
                        topName = name;
                    }
                }
            }

            //System.out.println(topName);
            ArrayList<Unit> units = new ArrayList<Unit>();

            for(String n2 : map.get(topName).keySet()) {
                units.add(map.get(topName).get(n2));
            }
            Collections.sort(units);
            //System.out.println(units.get(0));
            units.add(0, new Unit(topName, 1, false));
            String s = "";
            for(int i = 0; i < units.size(); i++) {
                Unit u = units.get(i);
                s += u.value + u.name;
                if (i != units.size() - 1) {
                    s += " = ";
                }
            }
            System.out.println(s);
        }
    }
    public static Tuple findRelation(HashSet<String> visited, Tuple t, String name, String name2) {
        HashMap<String, Unit> units = map.get(name);
        if (units.containsKey(name2)) {
            Unit u = units.get(name2);
            if (u.inverse) t.b *= u.value;
            else t.a *= u.value;
            return t;
        }
        for(String uname : units.keySet()) {
            if (visited.contains(uname)) continue;
            Unit uu = units.get(uname);
            visited.add(uname);
            Tuple tt = new Tuple(t.a, t.b);
            if (uu.inverse) tt.b *= uu.value;
            else tt.a *= uu.value;
            Tuple ttt = findRelation(visited, tt, uname, name2);
            if (ttt != null) return ttt;
            visited.remove(uname);
        }
        return null;
    }
}
