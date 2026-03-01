import { Home } from "./pages/Home";
import { Footer } from "./shared/Footer";
import { Header } from "./shared/Header";

function App() {
  //jsx
  return (
    <div className="dark min-h-screen bg-background text-foreground">
      <Header />
      <Home />
      <Footer />
    </div>
  );
}

export default App;
