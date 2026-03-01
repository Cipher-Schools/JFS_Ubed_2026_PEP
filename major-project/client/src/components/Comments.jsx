import React from "react";

export const Comment = ({ comment }) => {
  return (
    <div className="flex gap-3 group">
      <div className="flex items-center justify-center w-8 h-8 rounded-full bg-neutral-900 text-neutral-100 font-bold text-xs shrink-0 shadow-sm cursor-pointer border border-neutral-800">
        {comment.author.username[0].toUpperCase()}
      </div>
      <div className="flex-1">
        <div className="flex items-baseline gap-2 mb-1">
          <span className="font-bold text-sm text-neutral-100 cursor-pointer hover:text-white transition-colors">
            {comment.author.username}
          </span>
          <span className="text-xs text-neutral-500 font-medium">
            {new Date(comment.createdAt).toLocaleDateString()}
          </span>
        </div>
        <p className="text-sm text-neutral-300 leading-relaxed">
          {comment.content}
        </p>
      </div>
      <button
        className="text-neutral-600 hover:text-red-500 hover:bg-neutral-900 rounded-full w-6 h-6 flex items-center justify-center transition-all shrink-0 text-xs opacity-0 group-hover:opacity-100 focus:opacity-100"
        title="Delete comment"
      >
        ✕
      </button>
    </div>
  );
};
