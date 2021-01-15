import './styles.css';
import { ReactComponent as Linkedin } from './Linkedin.svg';
import { ReactComponent as Youtube} from './Youtube.svg';
import { ReactComponent as Instagram } from './Instagram.svg';
function Footer(){
    return(
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
                <a href='https://youtube.com' target="_new">
                    <Youtube />
                </a>
                <a href='https://linkedin.com' target="_new">
                    <Linkedin />
                </a>
                <a href='https://www.instagram.com' target="_new">
                    <Instagram />
                </a>
            </div>
        </footer>
    )
}

export default Footer;