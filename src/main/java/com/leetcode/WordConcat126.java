package com.leetcode;

import java.util.*;

/**
 * @Description
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换后得到的单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: []
 *
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 *
 * "kiss"
 * "tusk"
 * ["miss","dusk","kiss","musk","tusk","diss","disk","sang","ties","muss"]
 *
 * ["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]
 *
 * "hit"
 * "cog"
 * ["hot","dot","dog","lot","log","cog"]
 *
 * @Author nya
 * @Date 2020/6/28 上午10:58
 **/
public class WordConcat126 {

    public static void main(String[] args) {
        WordConcat126 concat = new WordConcat126();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"));
        String beginWord = "cet";
        String endWord = "ism";
//        ArrayList<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
//        String beginWord = "hit";
//        String endWord = "cog";

        List<List<String>> ladders = concat.findLadders(beginWord, endWord, list);
        System.out.println(ladders);

    }

    public List<List<String>> findLadders(String beginWord,String endWord,List<String> wordList) {
        Map<String,Integer> wordIdMap = new HashMap<>(); // 单词到id的映射
        List<String> idWordList = new ArrayList<>(); // id到单词的映射

        int id = 0;
        // 将wordList所有单词加入wordIdMap中,相同的只保留一个,并为每个单词分配一个id
        for (String word : wordList) {
            if (!wordIdMap.containsKey(word)) {
                wordIdMap.put(word,id++);
                idWordList.add(word);
            }
        }

        // 将beginWord也加入到wordIdMap中
        if (!wordIdMap.containsKey(beginWord)) {
            wordIdMap.put(beginWord,id++);
            idWordList.add(beginWord);
        }

        // 图的边
        ArrayList<Integer>[] edges = new ArrayList[idWordList.size()];
        for (int i = 0; i < idWordList.size(); i++) {
            edges[i] = new ArrayList<>();
        }

        // 添加边
        for (int i = 0 ; i < idWordList.size(); i++) {
            for (int j = i + 1; j < idWordList.size(); j++) {
                // 若两者可以通过转换得到 则它们同建一条无向边
                if (isChangeOne(idWordList.get(i),idWordList.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        // 目的ID
        int dest = wordIdMap.get(endWord);
        // 保存结果集
        List<List<String>> res = new ArrayList<>();
        // 到每个点的代价
        int[] cost = new int[id];
        for (int i = 0 ; i < id; i++) {
            // 代价初始化为无穷大
            cost[i] = 1 << 20;
        }

        // 将起点加入队列, 并将其cost设为0
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> tempBegin = new ArrayList<>();
        tempBegin.add(wordIdMap.get(beginWord));
        queue.add(tempBegin);
        cost[wordIdMap.get(beginWord)] = 0;

        // 开始广度优先搜索
        while (!queue.isEmpty()) {
            ArrayList<Integer> now = queue.poll();
            // 最近访问的点
            Integer latest = now.get(now.size() - 1);
            // 若该点为终点,则将其存入答案res
            if (latest == dest) {
                ArrayList<String> temp = new ArrayList<>();
                for (int index : now) {
                    temp.add(idWordList.get(index));
                }
                res.add(temp);
            } else {
                // 改点不为终点, 继续搜索
                for (int i = 0; i < edges[latest].size(); i++) {
                    // 获取该节点的所有无向边
                    Integer wordIndex = edges[latest].get(i);
                    // 此处 <= 目的 在于 把代价相同的不同路径全部保留下来
                    if (cost[latest] + 1 <= cost[wordIndex]) {
                        cost[wordIndex] = cost[latest] + 1;
                        // 把当前wordIndex加入路径中
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(wordIndex);
                        queue.add(tmp);
                    }
                }
            }

        }
        return res;
    }

    private static Map<String,Integer> mapping = new HashMap<>();

    public List<List<String>> findLadder(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resList = new ArrayList<>();
        Map<String,Integer> bfsMap = new HashMap<>();
        mapLines(beginWord,wordList,mapping);
        List<String> itemsHere = new ArrayList<>();
        itemsHere.add(beginWord);
        getLinks(beginWord,endWord,wordList,itemsHere,resList,bfsMap);
        System.out.println(bfsMap.get(endWord));
        return resList;
    }

    public void getLinks(String beginWord,String endWord,List<String> wordList,List<String> items,List<List<String>> res,Map<String,Integer> bfsMap) {
        List<String> nextWords = nextWords(beginWord, wordList);
        Integer distance = bfsMap.get(beginWord);
        if (distance == null) {
            distance = 0;
        }
        distance += 1;
        if (nextWords.size() > 0) {
            wordList.removeAll(nextWords);
            for (String item : nextWords) {
                if (!bfsMap.containsKey(item)) {
                    bfsMap.put(item,distance);
                    if (item.equals(endWord)) {
                        items.add(item);
                        res.add(items);
                    } else {
                        List<String> here = new ArrayList<>(items);
                        here.add(item);
                        getLinks(item,endWord,new ArrayList<>(wordList),here,res,bfsMap);
                    }
                }
            }
        }
    }

    /**
     *
     * @param beginWord
     * @param wordList
     * @param bfsMap
     */
    public void mapLines(String beginWord,List<String> wordList,Map<String,Integer> bfsMap) {
        List<String> nextWords = nextWords(beginWord, wordList);
        Integer distance = bfsMap.get(beginWord);
        if (distance == null) {
            distance = 0;
        }
        Integer here = distance + 1;
        if (nextWords.size() > 0) {
            wordList.removeAll(nextWords);
            for (String item : nextWords) {
                if (!bfsMap.containsKey(item)) {
                    bfsMap.put(item,here);
                    mapLines(item,new ArrayList<>(wordList),bfsMap);
                }
            }
        }
    }

    /**
     * 获取单词在词典中的所有可转换词典
     * @param word
     * @param wordList
     * @return
     */
    private List<String> nextWords(String word,List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (String item : wordList) {
            if (isChangeOne(word,item)) {
                res.add(item);
            }
        }
        return res;
    }

    /**
     * 比较两个单词是否可转换
     * @param word1
     * @param word2
     * @return
     */
    private boolean isChangeOne(String word1,String word2){
        int count = 0;
        for (int i = 0;i < word1.length();i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

}
