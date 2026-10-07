<template>
  <section class="stats-section" id="impact">
    <div class="paw-prints" aria-hidden="true">
      <svg class="paw sp1" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
      <svg class="paw sp2" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
      <svg class="paw sp3" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
      <svg class="paw sp4" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
      <svg class="paw sp5" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
      <svg class="paw sp6" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
        <g fill="currentColor">
          <ellipse cx="50" cy="72" rx="22" ry="18" />
          <ellipse cx="22" cy="48" rx="10" ry="13" transform="rotate(-20 22 48)" />
          <ellipse cx="78" cy="48" rx="10" ry="13" transform="rotate(20 78 48)" />
          <ellipse cx="34" cy="30" rx="9" ry="11" transform="rotate(-10 34 30)" />
          <ellipse cx="66" cy="30" rx="9" ry="11" transform="rotate(10 66 30)" />
        </g>
      </svg>
    </div>
    <div class="stats-header">
      <p class="stats-eyebrow">Notre impact</p>
      <h2>Des chiffres qui<br /><em>parlent d'eux-mêmes.</em></h2>
    </div>
    <div class="stats-row">
      <div
        v-for="(stat, i) in stats"
        :key="stat.label"
        class="stat-item"
        :class="{ visible: hasStarted }"
        :style="{ transitionDelay: `${i * 130}ms` }"
      >
        <div class="stat-number">
          <span class="count">{{ formatNumber(displayValues[i]) }}</span>
          <span class="suffix">{{ stat.suffix }}</span>
        </div>
        <p class="stat-label">{{ stat.label }}</p>
      </div>
    </div>
  </section>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue'

const stats = [
  { target: 12400, suffix: '+', label: 'Animaux adoptés' },
  { target: 340, suffix: '+', label: 'Refuges partenaires' },
  { target: 98, suffix: '%', label: 'Taux de satisfaction' },
  { target: 52, suffix: '+', label: 'Villes couvertes' },
]

const displayValues = ref(stats.map(() => 0))
const hasStarted = ref(false)
let observer = null

function formatNumber(val) {
  return Math.floor(val).toLocaleString('fr-FR')
}

function animateCounters() {
  const duration = 2000
  const startTime = performance.now()
  function tick(now) {
    const elapsed = now - startTime
    const progress = Math.min(elapsed / duration, 1)
    const eased = 1 - Math.pow(1 - progress, 3)
    displayValues.value = stats.map((s) => s.target * eased)
    if (progress < 1) requestAnimationFrame(tick)
  }
  requestAnimationFrame(tick)
}

onMounted(() => {
  const section = document.querySelector('.stats-section')
  observer = new IntersectionObserver(
    (entries) => {
      if (entries[0].isIntersecting && !hasStarted.value) {
        hasStarted.value = true
        animateCounters()
        observer.disconnect()
      }
    },
    { threshold: 0.3 },
  )
  if (section) observer.observe(section)
})

onUnmounted(() => observer?.disconnect())
</script>

<style scoped>
.stats-section {
  position: relative;
  background: #fff;
  padding: 5rem 5vw;
  overflow: hidden;
  border-top: 1px solid #f0f0f0;
}

.paw-prints {
  position: absolute;
  inset: 0;
  pointer-events: none;
  z-index: 0;
}
.paw {
  position: absolute;
  color: #c8a84b;
}
.sp1 {
  width: 86px;
  top: 5%;
  left: 0%;
  opacity: 0.09;
  transform: rotate(-20deg);
}
.sp2 {
  width: 64px;
  bottom: 8%;
  left: 5%;
  opacity: 0.07;
  transform: rotate(35deg);
}
.sp3 {
  width: 74px;
  top: 15%;
  left: 28%;
  opacity: 0.06;
  transform: rotate(-10deg);
}
.sp4 {
  width: 80px;
  bottom: 5%;
  right: 28%;
  opacity: 0.07;
  transform: rotate(22deg);
}
.sp5 {
  width: 90px;
  top: 8%;
  right: 3%;
  opacity: 0.09;
  transform: rotate(-38deg);
}
.sp6 {
  width: 62px;
  bottom: 10%;
  right: 12%;
  opacity: 0.06;
  transform: rotate(48deg);
}
.stats-header {
  position: relative;
  z-index: 1;
  text-align: center;
  margin-bottom: 4rem;
}

.stats-eyebrow {
  font-size: 0.78rem;
  font-weight: 600;
  letter-spacing: 0.12em;
  text-transform: uppercase;
  color: #c8a84b;
  margin-bottom: 0.75rem;
}

.stats-header h2 {
  font-family: 'Playfair Display', serif;
  font-size: clamp(2rem, 3.5vw, 3rem);
  line-height: 1.2;
  color: #1a1a2e;
  margin: 0;
}

.stats-header h2 em {
  font-style: italic;
  color: #1a1a2e;
}

.stats-row {
  position: relative;
  z-index: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  max-width: 900px;
  margin: 0 auto;
}

.stat-item {
  flex: 1;
  text-align: center;
  padding: 0 2.5rem;
  opacity: 0;
  transform: none;
  translate: none;
}

.stat-item.visible {
  opacity: 1;
  transform: translateY(0);
}

.stat-item + .stat-item {
  border-left: 1.5px solid #e8e0cc;
}

.stat-number {
  display: flex;
  align-items: baseline;
  justify-content: center;
  gap: 1px;
  margin-bottom: 0.5rem;
}

.count {
  font-family: 'Playfair Display', serif;
  font-size: clamp(2.6rem, 4vw, 3.4rem);
  font-weight: 900;
  color: #1a1a2e;
  line-height: 1;
  letter-spacing: -1.5px;
}

.suffix {
  font-family: 'Playfair Display', serif;
  font-size: clamp(1.6rem, 2.5vw, 2rem);
  font-weight: 700;
  color: #c8a84b;
  line-height: 1;
}

.stat-label {
  font-size: 0.82rem;
  font-weight: 500;
  color: #999;
  letter-spacing: 0.04em;
  text-transform: uppercase;
  margin: 0;
}

@media (max-width: 640px) {
  .stats-row {
    flex-direction: column;
    gap: 2.5rem;
  }
  .stat-item + .stat-item {
    border-left: none;
    border-top: 1.5px solid #e8e0cc;
    padding-top: 2.5rem;
  }
}
</style>
