<template>
  <section class="services">
    <div class="services-visual">
      <div class="teal-circle">
        <img src="@/assets/pet2.jpg" alt="Chien heureux" />
      </div>
    </div>
    <div class="services-text">
      <p class="eyebrow">PLANIFIER UNE ADOPTION</p>
      <h2>Les animaux ne sont pas toute notre vie, mais ils la rendent entière.</h2>
      <p class="services-desc">
        Parcourez les profils d'animaux disponibles à l'adoption, connectez-vous avec des refuges de
        confiance et trouvez votre compagnon idéal en quelques clics.
      </p>
      <div class="services-btns">
      <router-link to="/posts" class="btn-link">
        Planifier une adoption →
      </router-link>
      </div>
    </div>
  </section>
</template>

<script setup></script>

<style scoped>
.services {
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
  font-size: clamp(1.8rem, 3vw, 2.4rem);
  color: #1a1a2e;
  line-height: 1.25;
  margin-bottom: 1.5rem;
}
.services-desc {
  font-size: 0.92rem;
  color: #555;
  line-height: 1.75;
  margin-bottom: 2rem;
}
.services-btns {
  display: flex;
  align-items: center;
  gap: 1.5rem;
  flex-wrap: wrap;
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

.services-visual {
  display: flex;
  justify-content: center;
  align-items: center;
}
.teal-circle {
  width: 380px;
  height: 380px;
  border-radius: 50%;
  overflow: hidden;
  background: #7ecec4;
  border: 12px solid #7ecec4;
  box-shadow: 0 12px 40px rgba(126, 206, 196, 0.35);
}
.teal-circle img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 50%;
}

@media (max-width: 820px) {
  .services {
    grid-template-columns: 1fr;
  }
  .teal-circle {
    width: 260px;
    height: 260px;
  }
}
</style>
