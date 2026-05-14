class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashmapFirst = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hashmapSecond = new HashMap<Character, Integer>();
        for (int i=0; i<s.length(); i++)
        {
            if (hashmapFirst.containsKey(s.charAt(i)))
            {
                hashmapFirst.put(s.charAt(i), hashmapFirst.get(s.charAt(i))+1);
            }
            else
            {
                hashmapFirst.put(s.charAt(i),1);
            }
        }

        for (int i=0; i<t.length(); i++)
        {
            if (hashmapSecond.containsKey(t.charAt(i)))
            {
                hashmapSecond.put(t.charAt(i), hashmapSecond.get(t.charAt(i))+1);
            }
            else
            {
                hashmapSecond.put(t.charAt(i),1);
            }
        }

        int sizeFirstHm = hashmapFirst.size();
        int sizeSecondHm = hashmapSecond.size();
        if (sizeFirstHm != sizeSecondHm)
        {
            return false;
        }

        for (Character c : hashmapFirst.keySet())
        {
            if (!(hashmapSecond.containsKey(c) && hashmapSecond.get(c) == hashmapFirst.get(c)))
            {
                return false;
            }
        }

        return true;
    }
}
