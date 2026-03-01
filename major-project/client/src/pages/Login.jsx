import React from "react";
import { Link } from "react-router-dom";

export const Login = () => {
  return (
    <div className="min-h-screen flex items-center justify-center px-4 py-12 bg-black text-white">
      <div className="w-full max-w-md bg-black border border-neutral-900 rounded-2xl p-8 shadow-2xl transition-all duration-300">
        <h1 className="text-4xl font-extrabold text-white text-center mb-2 tracking-tight">
          Instagram
        </h1>
        <p className="text-center text-neutral-400 mb-8 font-medium">
          Login to your account
        </p>

        <form className="space-y-5">
          <div className="space-y-2">
            <label
              className="text-sm font-semibold text-neutral-300 ml-1"
              htmlFor="email"
            >
              Email
            </label>
            <input
              id="email"
              type="email"
              placeholder="demo@example.com"
              defaultValue="demo@example.com"
              className="w-full px-4 py-3 bg-neutral-950 border border-neutral-900 rounded-xl text-white placeholder-neutral-600 focus:outline-none focus:ring-1 focus:ring-neutral-700 focus:border-neutral-700 transition-all duration-200"
            />
          </div>

          <div className="space-y-2">
            <label
              className="text-sm font-semibold text-neutral-300 ml-1"
              htmlFor="password"
            >
              Password
            </label>
            <input
              id="password"
              type="password"
              placeholder="••••••••"
              defaultValue="password123"
              className="w-full px-4 py-3 bg-neutral-950 border border-neutral-900 rounded-xl text-white placeholder-neutral-600 focus:outline-none focus:ring-1 focus:ring-neutral-700 focus:border-neutral-700 transition-all duration-200"
            />
          </div>

          <button
            type="button"
            className="w-full py-3 mt-4 bg-white text-black rounded-xl font-bold shadow-lg shadow-white/5 hover:bg-neutral-200 hover:-translate-y-0.5 active:translate-y-0 transition-all duration-200"
          >
            Log In
          </button>
        </form>

        <div className="mt-8 relative flex items-center justify-center">
          <div className="absolute inset-0 flex items-center">
            <div className="w-full border-t border-neutral-900"></div>
          </div>
          <div className="relative bg-black px-4 text-sm text-neutral-500">
            Or continue with
          </div>
        </div>

        <div className="mt-8 text-center text-sm text-neutral-400 font-medium">
          <p>
            Don't have an account?{" "}
            <Link
              to="/register"
              className="text-white hover:text-neutral-300 font-bold transition-colors hover:underline decoration-1 underline-offset-4"
            >
              Sign up
            </Link>
          </p>
        </div>
      </div>
    </div>
  );
};
