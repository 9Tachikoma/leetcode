class Twitter {
    private static int timestamp = 0;

    private static class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    private static class User {
        private int id;
        private Set<Integer> followed;
        // 用户发表的推文链表头结点
        public Tweet head;

        public User(int id) {
            followed = new HashSet<>();
            this.id = id;
            this.head = null;
            //关注一下自己
            followed(id);
        }

        public void follow(int UserId) {
            followed.add(UserId);
        }

        public void unfollow(int UserId) {
            if (UserId != this.id)
                followed.remove(UserId);
        }

        public void post(int tweetId) {
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;
            // 将新建的推文插入链表头
            twt.next = head;
            head = twt;
        }
    }

    //用一个映射将userId与User对应起来
    private HashMap<Integer,User> userMap = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId))
            userMap.put(userId,new User(userId));
        User u = userMap.get(userId);
        u.post(tweetId);
    }

    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId)
            userMap.put(followerId,u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId)
            userMap.put(followeeId,u);
        }
        userMap.get(followeeId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(userMap.containKey(followerId)){
            User flwer = userMap.get(followeeId);
            flwer.unfollow(followerId);
        }
    }


    public List<Integer> getNewsFeed(int userId) {

    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */