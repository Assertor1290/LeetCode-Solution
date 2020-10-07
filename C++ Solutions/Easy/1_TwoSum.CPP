#include<bits/stdc++.h>
using namespace std;
class SolutionTwoSum {
public:
    /**Method 1: Brute Force Approach
    *Time Complexity: O(n^2)
    *Space Complexity: O(1)
    */
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        for(int i = 0; i < nums.size(); i++) {
            for(int j = i+1; j < nums.size(); j++) {
                if (nums[i]+nums[j] == target) {
                    result.push_back(i);
                    result.push_back(j);
                    return result;
                }
            }
        }
        return result;
    }
    /**Method 2: One Pass / Hash
    *Time Complexity: O(n)
    *Space Complexity: O(n)
    */
    vector<int> twoSum2(vector<int>& nums, int target) {
        unordered_map<int, int> hash;
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            if (hash.find(target - nums[i]) != hash.end()) {
                result.push_back(hash[target - nums[i]]);
                result.push_back(i);
                return result;
            }
            hash[nums[i]] = i;
        }
        return result;
    }
};
//Method to print in the desired form.
void print(vector<int> v_result) {
    cout << "[";
    for(int i = 0; i < v_result.size(); i++){
        cout << v_result[i];
        if(v_result.size()-1 != i)cout << ",";
    }
    cout << "]" << endl;
}

int main() {
    SolutionTwoSum s;
    //input vector
    vector<int> input = {2, 7, 11, 15};
    //resultant vector
    vector<int> v_result;
    //Method 1
    v_result = s.twoSum(input,9);
    print(v_result);
    //Method 2
    v_result = s.twoSum2(input,9);
    print(v_result);
    return 0;
}
