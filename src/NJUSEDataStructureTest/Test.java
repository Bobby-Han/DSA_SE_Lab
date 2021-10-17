package NJUSEDataStructureTest;

import DemoInClass.DemoInClass0924.BinarySearch;
import DemoInClass.DemoInClass0924.SelectionSort;
import DemoInClass.DemoInClass0928.MaxSubSequence;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test00(){
        int[] array={1,5,7,9,3,6,0};
        int[] afterSelectionSort= SelectionSort.selectionSort(array);
        int[] res={0,1,3,5,6,7,9};
        Assert.assertArrayEquals(res,afterSelectionSort);
    }

    @org.junit.Test
    public void test01(){
        int[] array={1,4,3,5,6,7,3};
        int ans= BinarySearch.binarySearchLeftMost(array,3);
        Assert.assertEquals(1,ans);
    }
    @org.junit.Test
    public void testMaxSubSequence(){
        int[] array={4,-3,5,-2,-1,2,6,-2};
        int res=11;
        Assert.assertEquals(11, MaxSubSequence.findMaxSubSequence(array,0,array.length-1));

    }
}
