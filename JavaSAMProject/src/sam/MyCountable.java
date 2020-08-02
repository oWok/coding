package sam;

import java.util.List;

@FunctionalInterface

public interface MyCountable {
    public int myCount(List<Integer> list); // SAM
    public String toString();
    public boolean equals(Object o);
}
