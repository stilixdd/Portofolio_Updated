// Smooth scrolling for internal anchors
document.querySelectorAll('a[href^="#"]').forEach(a => {
  a.addEventListener('click', e => {
    const target = document.querySelector(a.getAttribute('href'));
    if (target) {
      e.preventDefault();
      target.scrollIntoView({ behavior: 'smooth' });
    }
  });
});

// ==== About flip card: EN <-> DE ====
const aboutCard = document.getElementById('about-card');
const langToggle = document.getElementById('lang-toggle');

if (aboutCard && langToggle) {
  langToggle.addEventListener('click', () => {
    const flipped = aboutCard.classList.toggle('flipped');
    // Toggle text and icon
    if (flipped) {
      langToggle.innerHTML = '🌐 EN';
      langToggle.setAttribute('aria-label', 'Switch to English');
    } else {
      langToggle.innerHTML = '🌐 DE';
      langToggle.setAttribute('aria-label', 'Switch to Deutsch');
    }
    langToggle.setAttribute('aria-pressed', flipped ? 'true' : 'false');
  });

  // Optional: Keyboard shortcut (press "L" to flip)
  document.addEventListener('keydown', (e) => {
    if (e.key.toLowerCase() === 'l') langToggle.click();
  });
}



// ==== Theme toggle ====
const themeBtn = document.getElementById("theme-btn");
const body = document.body;

// Check stored preference OR default to dark
const savedTheme = localStorage.getItem("theme");
if (savedTheme === "light") {
  body.classList.remove("dark");
} else {
  // Default to dark if nothing stored
  body.classList.add("dark");
  localStorage.setItem("theme", "dark");
}

// Toggle on click
themeBtn.addEventListener("click", () => {
  body.classList.toggle("dark");
  const newTheme = body.classList.contains("dark") ? "dark" : "light";
  localStorage.setItem("theme", newTheme);
});

// Avatar flip tap support (mobile)
const avatarFlip = document.querySelector('.avatar-flip');
if (avatarFlip) {
  avatarFlip.addEventListener('click', () => {
    avatarFlip.classList.toggle('flipped');
  });
}

