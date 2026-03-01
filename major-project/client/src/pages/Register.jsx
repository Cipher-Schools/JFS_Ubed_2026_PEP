import React from "react";
import { Link } from "react-router-dom";

export const Register = () => {
  return (
    <div className="min-h-screen flex items-center justify-center px-4 py-12 bg-black text-white font-sans">
      <div className="w-full max-w-md bg-black border border-neutral-900 rounded-xl p-8 shadow-2xl transition-all duration-300">
        <h1 className="text-4xl font-extrabold text-white text-center mb-2 tracking-tight">
          Instagram
        </h1>
        <p className="text-center text-neutral-400 mb-8 font-medium">
          Create a new account
        </p>

        <form className="space-y-5">
          <div className="space-y-2">
            <label
              className="text-sm font-semibold text-neutral-300 ml-1"
              htmlFor="username"
            >
              Username
            </label>
            <input
              id="username"
              type="text"
              placeholder="e.g. johndoe"
              defaultValue="john_doe"
              className="w-full px-4 py-3 bg-neutral-950 border border-neutral-900 rounded-lg text-white placeholder-neutral-600 focus:outline-none focus:ring-1 focus:ring-neutral-700 focus:border-neutral-700 transition-all duration-200"
            />
          </div>

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
              placeholder="john@example.com"
              defaultValue="john@example.com"
              className="w-full px-4 py-3 bg-neutral-950 border border-neutral-900 rounded-lg text-white placeholder-neutral-600 focus:outline-none focus:ring-1 focus:ring-neutral-700 focus:border-neutral-700 transition-all duration-200"
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
              className="w-full px-4 py-3 bg-neutral-950 border border-neutral-900 rounded-lg text-white placeholder-neutral-600 focus:outline-none focus:ring-1 focus:ring-neutral-700 focus:border-neutral-700 transition-all duration-200"
            />
          </div>

          <div className="space-y-2">
            <label
              className="text-sm font-semibold text-neutral-300 ml-1"
              htmlFor="confirm_password"
            >
              Confirm Password
            </label>
            <input
              id="confirm_password"
              type="password"
              placeholder="••••••••"
              defaultValue="password123"
              className="w-full px-4 py-3 bg-neutral-950 border border-neutral-900 rounded-lg text-white placeholder-neutral-600 focus:outline-none focus:ring-1 focus:ring-neutral-700 focus:border-neutral-700 transition-all duration-200"
            />
          </div>

          <button
            type="button"
            className="w-full py-3 mt-4 bg-white hover:bg-neutral-200 text-black rounded-lg font-bold transition-all duration-200"
          >
            Sign Up
          </button>
        </form>

        <div className="mt-8 relative flex items-center justify-center">
          <div className="absolute inset-0 flex items-center">
            <div className="w-full border-t border-neutral-900"></div>
          </div>
          <div className="relative bg-black px-4 text-sm text-neutral-500">
            Or
          </div>
        </div>

        <div className="mt-8 text-center text-sm text-neutral-400 font-medium">
          <p>
            Already have an account?{" "}
            <Link
              to="/login"
              className="text-white hover:text-neutral-300 font-bold transition-colors hover:underline decoration-1 underline-offset-4"
            >
              Log in
            </Link>
          </p>
        </div>
      </div>
    </div>
  );
};
