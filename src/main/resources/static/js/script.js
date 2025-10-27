document.addEventListener("DOMContentLoaded", () => {
  /* Smooth scrolling */
  document.querySelectorAll('a[href^="#"]').forEach(a => {
    a.addEventListener('click', e => {
      const target = document.querySelector(a.getAttribute('href'));
      if (target) { e.preventDefault(); target.scrollIntoView({ behavior: 'smooth' }); }
    });
  });

  /* About flip card */
  const aboutCard = document.getElementById('about-card');
  const langToggle = document.getElementById('lang-toggle');
  if (aboutCard && langToggle) {
    langToggle.addEventListener('click', () => {
      const flipped = aboutCard.classList.toggle('flipped');
      langToggle.innerHTML = flipped ? '🌐 EN' : '🌐 DE';
      langToggle.setAttribute('aria-label', flipped ? 'Switch to English' : 'Switch to Deutsch');
      langToggle.setAttribute('aria-pressed', flipped ? 'true' : 'false');
    });
    document.addEventListener('keydown', (e) => {
      if (e.key && e.key.toLowerCase() === 'l') langToggle.click();
    });
  }

  /* Theme toggle */
  const body = document.body;
  const themeBtn = document.getElementById("theme-btn");

  // Default to dark if nothing stored
  const savedTheme = localStorage.getItem("theme");
  const useDark = savedTheme ? savedTheme === "dark" : true;
  body.classList.toggle("dark", useDark);

  const setThemeButtonUI = () => {
    const isDark = body.classList.contains("dark");
    if (themeBtn) {
      themeBtn.textContent = isDark ? "☀️" : "🌙";
      themeBtn.setAttribute("aria-label", isDark ? "Switch to light mode" : "Switch to dark mode");
    }
  };
  setThemeButtonUI();

  if (themeBtn) {
    themeBtn.addEventListener("click", () => {
      body.classList.toggle("dark");
      const nowDark = body.classList.contains("dark");
      localStorage.setItem("theme", nowDark ? "dark" : "light");
      setThemeButtonUI();
    });
  }

  /* Avatar flip tap (mobile) */
  const avatarFlip = document.querySelector('.avatar-flip');
  if (avatarFlip) avatarFlip.addEventListener('click', () => avatarFlip.classList.toggle('flipped'));
});
