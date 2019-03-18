//
// Author: Moncef Mhasni
// Main solution
//
#include <bits/stdc++.h>
#define ll long long
using namespace std;

ll solve(ll n){
    if(n<=2) return 1;
    ll res = n;
    for(ll i = 2; i <= n ; i++){
        if(n%i == 0){
            res -= res/i;
            while(n%i == 0) n/=i;
        }
    }
    return res;
}

int main(){
    int tc;
    scanf("%d",&tc);
    while(tc--){
        ll n; scanf("%lld",&n);
        printf("%lld\n",solve(n));
    }
}