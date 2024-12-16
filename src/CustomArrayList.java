public class CustomArrayList {
    private Object[] elements;
    private int size;

    public CustomArrayList() {
        this.elements = new Object[10];
        this.size = 0;
    }

    public void add(Object element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    public String toFileString() {
        StringBuilder fileContent = new StringBuilder();
        for (int i = 0; i < size; i++) {
            fileContent.append(((Book) elements[i]).toFileString()).append("\n");
        }
        return fileContent.toString();
    }

    public static CustomArrayList fromFileString(String fileContent) {
        CustomArrayList list = new CustomArrayList();
        String[] lines = fileContent.split("\n");
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                list.add(Book.fromFileString(line));
            }
        }
        return list;
    }
}
