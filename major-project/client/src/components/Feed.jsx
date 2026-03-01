import React from "react";
import { Post } from "./Post";
import dummyData from "../data/dummy.json";

export const Feed = () => {
  const posts = dummyData.posts;

  return (
    <div className="max-w-2xl mx-auto px-4 py-8">
      <div className="flex items-center justify-between mb-8">
        <h1 className="text-3xl font-extrabold text-white tracking-tight">
          Your Feed
        </h1>
        <button
          className="p-2.5 bg-black border border-neutral-900 hover:bg-neutral-900 hover:border-neutral-800 rounded-xl transition-all shadow-sm hover:shadow-md active:scale-95 text-xl flex items-center justify-center text-neutral-300"
          title="Refresh"
        >
          🔄
        </button>
      </div>

      {posts.length === 0 ? (
        <div className="text-center py-16 bg-black border border-neutral-900 rounded-3xl shadow-[0_0_15px_rgba(0,0,0,0.8)]">
          <p className="text-neutral-500 font-medium">
            No posts yet. Start following people to see their posts!
          </p>
        </div>
      ) : (
        <div className="space-y-10">
          {posts.map((post) => (
            <Post key={post.id} post={post} />
          ))}
        </div>
      )}
    </div>
  );
};
