<template>
  <section class="about" id="about">
    <div class="about-text">
      <p class="eyebrow">À PROPOS DE NOUS</p>
      <h2>L'animal vit pour le jour, l'heure, même le moment.</h2>
      <p class="about-desc">
        Tous les membres de PawMates ont été soigneusement sélectionnés selon notre devise :
        <em>« prendre soin des animaux comme s'ils étaient les nôtres. »</em>
      </p>
      <p class="about-desc">
        Chaque refuge et famille d'accueil place la sécurité et le bien-être de l'animal au premier
        plan. Rejoignez PawMates et planifiez une adoption dès aujourd'hui.
      </p>
      <div class="about-btns ">
        <button
        class="btn-primary"
        @click="scrollToImpact"
      >
        Notre impact →
      </button>
      </div>
    </div>

    <div class="about-visual">
      <div class="teal-blob"></div>
      <img class="about-dog" src="@/assets/pet.jpg" alt="Chien souriant" />
    </div>
  </section>
</template>

<script setup>
const scrollToImpact = () => {
  document.getElementById('impact')
    ?.scrollIntoView({ behavior: 'smooth' })
}
</script>

<style scoped>
.about {
  display: grid;
  grid-template-columns: 1fr 1fr;
  align-items: center;
  gap: 4rem;
  padding: 6rem 5vw;
  background: #fff;
}
.eyebrow {
  font-size: 0.72rem;
  font-weight: 600;
  letter-spacing: 0.12em;
  color: #aaa;
  margin-bottom: 1rem;
}
h2 {
  font-family: 'Playfair Display', serif;
  font-size: clamp(1.8rem, 3vw, 2.6rem);
  color: #1a1a2e;
  line-height: 1.25;
  margin-bottom: 1.5rem;
}
.about-desc {
  font-size: 0.92rem;
  color: #555;
  line-height: 1.75;
  margin-bottom: 1rem;
}
.about-desc em {
  color: #1a1a2e;
  font-style: italic;
}
.about-btns {
  display: flex;
  align-items: center;
  gap: 1.5rem;
  margin-top: 1.5rem;
}
.btn-primary {
  background: #1a1a2e;
  color: #fff;
  border: none;
  padding: 0.8rem 1.8rem;
  border-radius: 6px;
  font-size: 0.9rem;
  font-family: 'DM Sans', sans-serif;
  font-weight: 500;
  cursor: pointer;
  transition: background 0.2s;
}
.btn-primary:hover {
  background: #c8a84b;
}
.btn-link {
  background: transparent;
  border: none;
  color: #1a1a2e;
  font-size: 0.9rem;
  font-family: 'DM Sans', sans-serif;
  font-weight: 500;
  cursor: pointer;
  text-decoration: underline;
  padding: 0;
}
.btn-link:hover {
  color: #c8a84b;
}

.about-visual {
  position: relative;
  height: 480px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.teal-blob {
  position: absolute;
  width: 360px;
  height: 360px;
  background: #bbe5f1;
  border-radius: 50% 40% 60% 40% / 40% 60% 40% 60%;
  z-index: 0;
}
.about-dog {
  position: relative;
  z-index: 1;
  width: 320px;
  height: 380px;
  object-fit: cover;
  border-radius: 50% 50% 50% 50% / 60% 60% 40% 40%;
  box-shadow: 0 12px 40px rgba(0, 0, 0, 0.15);
}

@media (max-width: 820px) {
  .about {
    grid-template-columns: 1fr;
  }
  .about-visual {
    height: 320px;
  }
  .teal-blob {
    width: 260px;
    height: 260px;
  }
  .about-dog {
    width: 240px;
    height: 280px;
  }
}
</style>
