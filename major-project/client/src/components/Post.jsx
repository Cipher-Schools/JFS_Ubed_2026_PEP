import React from "react";

export const Post = ({ post }) => {
  return (
    <article className="bg-black border border-neutral-900 rounded-3xl overflow-hidden shadow-lg shadow-black/40 hover:shadow-xl hover:shadow-black/60 transition-all duration-300">
      {/* Author Header */}
      <div className="p-4 border-b border-neutral-900 bg-black/50">
        <div className="flex items-center gap-4">
          <div className="flex items-center justify-center w-11 h-11 rounded-full bg-neutral-900 text-neutral-100 font-bold text-sm shrink-0 shadow-md ring-1 ring-neutral-800 cursor-pointer hover:ring-neutral-700 transition-all">
            {post.author.username[0].toUpperCase()}
          </div>
          <div className="flex-1 cursor-pointer group">
            <p className="font-bold text-neutral-100 group-hover:text-white transition-colors">
              {post.author.username}
            </p>
            <p className="text-xs text-neutral-500 font-medium">
              {new Date(post.createdAt).toLocaleDateString()}
            </p>
          </div>
          <button className="w-8 h-8 flex items-center justify-center text-neutral-500 hover:text-white hover:bg-neutral-900 rounded-full transition-colors font-bold">
            ⋮
          </button>
        </div>
      </div>

      {/* Post Image */}
      <div className="w-full bg-neutral-950 relative group border-b border-neutral-900">
        <img
          src={post.imageUrl}
          alt={post.caption}
          className="w-full h-auto max-h-[500px] object-cover"
        />
        {/* Subtle overlay on hover */}
        <div className="absolute inset-0 bg-black/0 group-hover:bg-black/20 transition-colors duration-300 pointer-events-none"></div>
      </div>

      {/* Actions & Caption */}
      <div className="p-5 border-b border-neutral-900">
        <div className="flex gap-4 mb-4 text-neutral-300">
          <button
            className="text-2xl hover:scale-110 active:scale-95 transition-transform hover:text-white"
            title="Like"
          >
            {post.liked ? "❤️" : "🤍"}
          </button>
          <button
            className="text-2xl hover:scale-110 active:scale-95 transition-transform hover:text-white"
            title="Comment"
          >
            💬
          </button>
          <button
            className="text-2xl hover:scale-110 active:scale-95 transition-transform hover:text-white"
            title="Share"
          >
            ➤
          </button>
        </div>

        <p className="text-sm font-bold text-neutral-100 mb-3">
          {post.likesCount} {post.likesCount === 1 ? "like" : "likes"}
        </p>

        {post.caption && (
          <div className="mb-3">
            <p className="text-sm text-neutral-300 leading-relaxed">
              <span className="font-bold text-neutral-100 cursor-pointer hover:text-white transition-colors mr-2">
                {post.author.username}
              </span>
              {post.caption}
            </p>
          </div>
        )}

        <p className="text-xs text-neutral-500 font-medium cursor-pointer hover:text-neutral-400 transition-colors inline-block mt-1">
          View all {post.commentsCount} comments
        </p>
      </div>

      {/* Comments */}
      <div className="bg-black/50">
        <div className="p-5 space-y-4 max-h-[300px] overflow-y-auto custom-scrollbar">
          {post.comments.length > 0 ? (
            post.comments.map((comment) => (
              <div key={comment.id} className="flex gap-3 group">
                <div className="flex items-center justify-center w-8 h-8 rounded-full bg-neutral-900 text-neutral-100 font-bold text-xs shrink-0 shadow-sm ring-1 ring-neutral-800 cursor-pointer">
                  {comment.author.username[0].toUpperCase()}
                </div>
                <div className="flex-1">
                  <p className="text-sm text-neutral-300 leading-relaxed">
                    <span className="font-bold text-neutral-100 cursor-pointer hover:text-white transition-colors mr-2">
                      {comment.author.username}
                    </span>
                    {comment.content}
                  </p>
                </div>
              </div>
            ))
          ) : (
            <p className="text-sm text-neutral-600 italic text-center py-2">
              No comments yet
            </p>
          )}
        </div>

        {/* Add Comment (static, no logic) */}
        <div className="border-t border-neutral-900 p-4 flex gap-3 bg-black">
          <input
            type="text"
            placeholder="Add a comment..."
            className="flex-1 bg-neutral-900 border border-neutral-800 rounded-full px-4 py-2 text-sm text-neutral-100 placeholder-neutral-500 focus:outline-none focus:ring-1 focus:ring-neutral-700 transition-all"
          />
          <button
            type="button"
            className="px-5 py-2 bg-white text-black rounded-full text-sm font-bold shadow-md hover:bg-neutral-200 transition-all"
          >
            Post
          </button>
        </div>
      </div>
    </article>
  );
};
