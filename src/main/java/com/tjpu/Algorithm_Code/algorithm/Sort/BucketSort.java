package com.tjpu.Algorithm_Code.algorithm.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {

    /**
     *
     * 一般对桶内的元素进行快排，或者递归，一下代码按照递归方式进行排序---复杂度O(n)---极端情况下---O(n*logN)
     * 空间复杂度-----O(N+M) N代表元素个数 M代表桶的个数
     * @param array 待排序集合
     * @param bucketSize 桶中元素类型的 个数，既每个桶能放多少数值
     * @return
     */
    public static List<Integer> bucketSort(List<Integer> array,int bucketSize){
        //合法性校验
        if(array==null||array.size()<2||bucketSize<1){
            return array;
        }
        //找出集合中元素最大值和最小值
        int max=array.get(0);
        int min=array.get(0);
        for (int i=0;i<array.size();i++){
            if (array.get(i)>max){
                max=array.get(i);
            }
            if (array.get(i)<min){
                min=array.get(i);
            }
        }

        //计算桶的个数【集合中的最小值到集合中的最大值】标识我们整个所有待排序数据的范围
        int bucketCount=(max-min)/bucketSize+1;
        //按照顺序创建桶，创建一个list，list带下标是有序的，list中的每一个元素就是一个桶，也用list桶
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i=0;i<bucketCount;i++){
            bucketList.add(new ArrayList<Integer>());
        }
        //将待排序的集合依次添加到对应的桶中
        for (int j=0;j<array.size();j++){
            int bucketIndex=(array.get(j)-min)/bucketSize;
            bucketList.get(bucketIndex).add(array.get(j));
        }
        //桶内元素的排序
        List<Integer> resultList = new ArrayList<>();
        for (int j=0;j<bucketList.size();j++){
            List<Integer> everyBucket = bucketList.get(j);
            //如果每个桶内右元素，进行递归排序
            if (everyBucket.size()>0){
                if(bucketCount==1){
                    bucketSize--;
                }
                List<Integer> temp = bucketSort(everyBucket,bucketSize);
                for (int i=0;i<temp.size();i++){
                    resultList.add(temp.get(i));
                }
            }
        }
        return resultList;
    }


    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(6);
        list.add(9);
        list.add(0);
        list.add(3);
        list.add(4);
        System.out.println("桶排序前得结果是---》："+list);
       List<Integer> bucketSort =  bucketSort(list,2);
        System.out.println("桶排序后得结果是---》："+bucketSort);
    }
}
