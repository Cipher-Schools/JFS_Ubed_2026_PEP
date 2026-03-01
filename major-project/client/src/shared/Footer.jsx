import React from "react";

export const Footer = () => {
  return (
    <footer className="border-t border-neutral-900 bg-black mt-auto">
      <div className="max-w-7xl mx-auto px-4 py-10">
        <div className="flex flex-wrap gap-x-8 gap-y-4 justify-center mb-8">
          <a
            href="#about"
            className="text-sm font-medium text-neutral-500 hover:text-neutral-300 transition-colors"
          >
            About
          </a>
          <a
            href="#help"
            className="text-sm font-medium text-neutral-500 hover:text-neutral-300 transition-colors"
          >
            Help Center
          </a>
          <a
            href="#api"
            className="text-sm font-medium text-neutral-500 hover:text-neutral-300 transition-colors"
          >
            API
          </a>
          <a
            href="#careers"
            className="text-sm font-medium text-neutral-500 hover:text-neutral-300 transition-colors"
          >
            Careers
          </a>
          <a
            href="#privacy"
            className="text-sm font-medium text-neutral-500 hover:text-neutral-300 transition-colors"
          >
            Privacy
          </a>
          <a
            href="#terms"
            className="text-sm font-medium text-neutral-500 hover:text-neutral-300 transition-colors"
          >
            Terms
          </a>
          <a
            href="#locations"
            className="text-sm font-medium text-neutral-500 hover:text-neutral-300 transition-colors"
          >
            Locations
          </a>
          <a
            href="#language"
            className="text-sm font-medium text-neutral-500 hover:text-neutral-300 transition-colors"
          >
            Language
          </a>
        </div>
        <div className="text-center">
          <p className="text-sm text-neutral-600">
            &copy; {new Date().getFullYear()} Instagram Clone. All rights
            reserved.
          </p>
        </div>
      </div>
    </footer>
  );
};
