public class HashTable {

    private int size;
    private LinkedList[] names;
    private LinkedList[] passwords;

    public HashTable(int size) {
        this.size = size;
        names = new LinkedList[size];
        passwords = new LinkedList[size];
        for(int i=0; i<size; i++) {
            passwords[i] = names[i] = null;
        }
    }

    private int getIndexToInsert(String s)
    {
        int hash=0;
        for (char c: s.toCharArray()) {
            hash+=(int) c;
        }
        return hash % size;
    }

    public void insert(String username,String password)
    {
        int index = getIndexToInsert(password);
        if(passwords[index] == null)
        {
            passwords[index] = new LinkedList(password);
            names[index] = new LinkedList(username);
        }
        else
        {
            passwords[index].addEnd(password);
            names[index].addEnd(username);
        }
    }


    public void getUsername(String key)
    {
        int index = getIndexToInsert(key);
        for(int i=0; i<passwords[index].count(key); i++)
        {
            int searchat = passwords[index].searchwith(key,i);
            System.out.println("Index: = " + index+  " - Linked List Loc = " + searchat);
            System.out.println(names[index].get(searchat));
        }

    }

}
