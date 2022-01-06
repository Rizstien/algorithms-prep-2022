# 3 Sum

Given an array `S` of `n` integers, are there elements `a, b, and c` in `S` such that `a + b + c = target`? Find all unique triplets in the array which gives the sum of target.

> **Note:**
> 
> -   Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
> -   The solution set must not contain duplicate triplets.

**Example :**  
Given array `S = {-3 2 0 -5 1 5}`, and `target = 0`  
A solution set is:

```
    (-5, 0, 5)
    (-3, 1, 2)

```

Also make sure that the solution set is lexicographically sorted.  
`Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])`
