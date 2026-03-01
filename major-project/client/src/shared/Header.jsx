import React from "react";

export const Header = () => {
  const isAuthenticated = true; // This should come from your authentication logic

  return (
    <header className="sticky top-0 z-50 border-b border-neutral-900 bg-black/90 backdrop-blur-md shadow-sm transition-all duration-300">
      <div className="max-w-7xl mx-auto px-4 h-16 flex items-center justify-between">
        <a
          href="/"
          className="text-2xl font-extrabold text-white tracking-tight hover:text-neutral-300 transition-colors"
        >
          Instagram
        </a>

        <nav className="flex items-center gap-6">
          {isAuthenticated ? (
            <>
              <a
                href="/"
                className="text-neutral-400 font-medium hover:text-white transition-colors"
              >
                Home
              </a>
              <a
                href="/explore"
                className="text-neutral-400 font-medium hover:text-white transition-colors"
              >
                Explore
              </a>
              <a
                href="/profile"
                className="text-neutral-400 font-medium hover:text-white transition-colors"
              >
                <div className="flex flex-col items-center justify-center w-9 h-9 rounded-full bg-neutral-900 text-neutral-100 font-bold text-sm shadow-md ring-1 ring-neutral-800 hover:ring-neutral-600 transition-all cursor-pointer">
                  J
                </div>
              </a>
              <button
                onClick={() => {
                  console.log("Logout");
                }}
                className="px-4 py-2 text-neutral-400 font-medium hover:bg-neutral-900 rounded-xl transition-all hover:text-white"
              >
                Logout
              </button>
            </>
          ) : (
            <>
              <a
                href="/login"
                className="text-neutral-400 font-medium hover:text-white transition-colors"
              >
                Login
              </a>
              <a
                href="/register"
                className="px-5 py-2 bg-white text-black rounded-xl font-bold hover:bg-neutral-200 transition-colors"
              >
                Sign Up
              </a>
            </>
          )}
        </nav>
      </div>
    </header>
  );
};
