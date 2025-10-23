class Solution
{
    public List<String> removeAnagrams(String[] words)
    {
        int[][] f=new int[words.length][26];
        for(int j=0;j<words.length;j++)
        {
            String k=words[j];
            for(int i=0;i<k.length();i++)
            {
                int idx=k.charAt(i)-'a';
                f[j][idx]++;
            }
        }

        for(int i=1;i<words.length;i++)
        {
            if(isAnagram(f[i],f[i-1])) 
                words[i]=null;
        }
        
        List<String> res=new ArrayList<>();
        for(String k:words)
            if(k!=null)
                res.add(k);

        return res;
    }

    boolean isAnagram(int[] f1,int f2[])
    {
        for(int i=0;i<26;i++)
            if(f1[i]!=f2[i])
                return false;
    
        return true;
    }
}
