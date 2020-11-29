import React from 'react';
import Head from 'next/head';
import styles from '../styles/Home.module.scss';
import Link from 'next/link';

export default function Home() {
    return (
        <div className={styles.container}>
            <Head>
                <title>Talento Digital final test</title>
                <link rel="icon" href="/favicon.ico"/>
            </Head>

            <main className={styles.main}>
                <h1 className={styles.title}>
                    Welcome to my app
                </h1>

                <div className={styles.grid}>
                    <Link href={'/sales-representatives'}>
                        <a className={styles.card}>
                            <h3>Program &rarr;</h3>
                            <p>Find in-depth information in my Github.</p>
                        </a>
                    </Link>

                    <a href="https://github.com/cristobalgvera/td-final-evaluation" className={styles.card}>
                        <h3>Github &rarr;</h3>
                        <p>🎊🎊</p>
                    </a>
                </div>
            </main>

            <footer className={styles.footer}>
                <a
                    href="https://vercel.com?utm_source=create-next-app&utm_medium=default-template&utm_campaign=create-next-app"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Powered by{' '}
                    <img src="/vercel.svg" alt="Vercel Logo" className={styles.logo}/>
                </a>
            </footer>
        </div>
    );
}
